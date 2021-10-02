from PIL import Image
import numpy as np

import torch
import torch.nn as nn
from torch.utils.data.sampler import SubsetRandomSampler
import torchvision.models as models
import torchvision.transforms as transforms
import torchvision.datasets as datasets


# Recreate the model that was used to train the images
model_transfer = models.googlenet(pretrained=True)

use_cuda = torch.cuda.is_available()
device = 'gpu' if torch.cuda.is_available() else 'cpu'
if use_cuda:
    model_transfer = model_transfer.cuda()

for param in model_transfer.parameters():
    param.requires_grad=True

n_inputs = model_transfer.fc.in_features
last_layer = nn.Linear(n_inputs, 4)
model_transfer.fc = last_layer

if use_cuda:
    model_transfer = model_transfer.cuda()


# Load the trained weights into the model
model_transfer.load_state_dict(torch.load('./model.pt', map_location=torch.device(device)))
model_transfer.eval()

# Class encodings
classes = ['BrownSpot', 'Healthy', 'Hispa', 'LeafBlast']
class_to_idx = {
    'BrownSpot': 0,
    'Healthy': 1,
    'Hispa': 2, 
    'LeafBlast': 3
}
idx_to_classes = {value: key for key, value in class_to_idx.items()}

# Transformations for test images
transformations = transforms.Compose([
    transforms.Resize(225),
    transforms.CenterCrop(224),
    transforms.ToTensor(),
    transforms.Normalize(
        [0.485, 0.456, 0.406],
        [0.229, 0.224, 0.225]
    )
])

img = Image.open('./images/leafblast.jpg')
img = transformations(img)
img = img.unsqueeze(0)

prediction = model_transfer(img)
predicted_idx = prediction.max(1, keepdim=True)[1].item()
predicted_class = idx_to_classes[predicted_idx]

print(predicted_class)
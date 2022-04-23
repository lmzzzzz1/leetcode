import torch
from torchvision import models
from torchsummary import summary

device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
res = models.alexnet().to(device)

summary(res, (3, 224, 224))
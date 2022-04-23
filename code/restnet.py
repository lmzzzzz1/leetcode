import torch
from torchvision.models import resnet18, alexnet, vgg
from thop import profile
from thop import clever_format
from torchsummary import summary




model = alexnet()
input = torch.randn(1, 3, 224, 224)
macs, params = profile(model, inputs=(input,))
print(macs)
print(params)
macs, params = clever_format([macs, params], "%.5f")

# summary(model, input_size=(3, 224, 224))
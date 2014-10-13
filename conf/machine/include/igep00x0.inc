
# X Window System
PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard"

# Linux Kernel
PREFERRED_PROVIDER_virtual/kernel ?= "linux"
KERNEL_IMAGETYPE ?= "zImage"

# A list of machine-specific packages to install as part of the image.
MACHINE_EXTRA_RRECOMMENDS += " kernel-modules kernel-devicetree virtual/bootloader"

# The entry point for the U-Boot image.
UBOOT_ENTRYPOINT = "0x80008000"
# The load address for the U-Boot image.
UBOOT_LOADADDRESS = "0x80008000"
# The suffix used for the U-Boot image.
UBOOT_SUFFIX ?= "img"
# The binary used for the U-Boot SPL image.
SPL_BINARY ?= "MLO"

# Specifies the format of the root filesystem.
IMAGE_FSTYPES += "tar.bz2"

# List of hardware features the MACHINE supports.
MACHINE_FEATURES ?= "alsa bluetooth usbgadget usbhost wifi"

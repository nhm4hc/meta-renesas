require rcar-image-minimal.bb

IMAGE_FEATURES += "ssh-server-openssh"

# Packages for Gateway platform
IMAGE_INSTALL_append = " \
    kernel-module-uio-pdrv-genirq \
    kernel-module-cmemdrv \
    kernel-module-cmemdrv-dev \
    udev-rules \
    packagegroup-oss \
"

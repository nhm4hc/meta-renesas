SUMMARY = "A image with support for ADAS applications."

require recipes-core/images/rcar-image-minimal.bb

IMAGE_INSTALL_append_rcar = " \
    packagegroup-v3x \
    packagegroup-oss \
    packagegroup-opencv-sdk \
    kernel-image \
    kernel-devicetree \
    kernel-modules \
"
IMAGE_INSTALL_append_r8a779g0 = "nvme-initscripts"


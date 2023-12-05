require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

RENESAS_BSP_URL = " \
    git://github.com/nhm4hc/linux-bsp.git"
BRANCH = "v5.10.194/rcar-5.3.0.rc5"
SRCREV = "76f12f95c2fc9bb202b56a3d22200d483e231a6e"

SRC_URI = "${RENESAS_BSP_URL};branch=${BRANCH};protocol=https"

# Add module.lds
SRC_URI_append = " \
    file://0001-scripts-Add-module.lds-to-fix-out-of-tree-modules-bu.patch \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

S = "${WORKDIR}/git"

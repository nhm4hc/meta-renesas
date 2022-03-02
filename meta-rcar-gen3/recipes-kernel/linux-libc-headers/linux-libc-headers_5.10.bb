require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

RENESAS_BSP_URL = " \
    git://github.com/renesas-rcar/linux-bsp.git"
BRANCH = "${@oe.utils.conditional("USE_SAFE_RENDERING", "1", "v5.10.41/rcar-5.1.1", "v5.10.41/rcar-5.1.4", d)}"
SRCREV = "${@oe.utils.conditional("USE_SAFE_RENDERING", "1", \
    "3e1beedbebfb92917a715b6c8438403de9e644d8", \
    "4846ef7755062737891d10bf15da4721bfb79b04", d)}"

SRC_URI = "${RENESAS_BSP_URL};branch=${BRANCH};protocol=https"

# Add module.lds
SRC_URI_append = " \
    file://0001-scripts-Add-module.lds-to-fix-out-of-tree-modules-bu.patch \
"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

S = "${WORKDIR}/git"

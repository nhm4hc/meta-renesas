DESCRIPTION = "OSS packages for S4 development & testing"

LICENSE = "BSD-3-Clause & GPLv2+ & LGPLv2+"

inherit packagegroup

PACKAGES = " \
    packagegroup-oss \
"

# OSS packages for development
RDEPENDS_packagegroup-oss = " \
    gdb \
    gdbserver \
    openssh-sftp \
    openssh-sftp-server \
"

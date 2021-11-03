require include/rcar-gen3-modules-common.inc

inherit features_check

REQUIRED_DISTRO_FEATURES = "avb"

SRC_URI = "gitsm://github.com/renesas-rcar/avb-applications.git;branch=rcar-gen3"
SRCREV = "386bf3d9b1582ed706efb2c1929f43d0005e9094"

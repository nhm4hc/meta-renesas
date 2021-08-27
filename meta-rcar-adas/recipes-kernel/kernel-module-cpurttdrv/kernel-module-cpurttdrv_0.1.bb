SUMMARY = "CPURTT drive Module"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://${S}/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://${S}/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
"

RENESAS_CPURTTDRV_URL ?= "git://github.com/renesas-rcar/cpurttdrv.git"
SRCREV = "9fa5d65ceae71080a8bb7b9b9df0661d020e5ce5"

PR = "r0"
PV = "0.1"

require kernel-module-cpurttdrv.inc

do_install_append () {
    install -d ${D}${prefix}/local/include
    install -m 644 ${S}/cpurtt_common.h ${D}${prefix}/local/include
}

FILES_${PN} = "${prefix}/local/include/cpurtt_common.h"

KERNEL_MODULE_PROBECONF += "cpurttmod"
module_conf_cpurttmod = "blacklist cpurttmod"

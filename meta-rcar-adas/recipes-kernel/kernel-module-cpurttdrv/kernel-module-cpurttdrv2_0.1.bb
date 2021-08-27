SUMMARY = "CPURTT drive Module"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://${S}/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://${S}/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
"

RENESAS_CPURTTDRV_URL ?= "git://github.com/renesas-rcar/cpurttdrv2.git"
SRCREV = "301cef03b89dc3f074f4985effd6e85f83564ccd"

PR = "r0"
PV = "0.1"

require kernel-module-cpurttdrv.inc

do_install_append () {
    install -d ${D}${prefix}/local/include/cpurttmod2_v3h1
    install -d ${D}${prefix}/local/include/cpurttmod2_v3h2
    install -d ${D}${prefix}/local/include/cpurttmod2_v3m2
    install -m 644 ${S}/v3h1/cpurtt_common.h ${D}${prefix}/local/include/cpurttmod2_v3h1
    install -m 644 ${S}/v3h2/cpurtt_common.h ${D}${prefix}/local/include/cpurttmod2_v3h2
    install -m 644 ${S}/v3m2/cpurtt_common.h ${D}${prefix}/local/include/cpurttmod2_v3m2
}

FILES_${PN}-dev = " \
    ${prefix}/local/include/cpurttmod2_v3h1 \
    ${prefix}/local/include/cpurttmod2_v3h2 \
    ${prefix}/local/include/cpurttmod2_v3m2 \
"

KERNEL_MODULE_PROBECONF += "cpurttmod2_v3h1 cpurttmod2_v3h2 cpurttmod2_v3m2"
module_conf_cpurttmod2_v3h1 = "blacklist cpurttmod2_v3h1"
module_conf_cpurttmod2_v3h2 = "blacklist cpurttmod2_v3h2"
module_conf_cpurttmod2_v3m2 = "blacklist cpurttmod2_v3m2"

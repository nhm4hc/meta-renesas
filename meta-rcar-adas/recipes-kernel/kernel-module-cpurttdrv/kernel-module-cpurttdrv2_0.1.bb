SUMMARY = "CPURTT drive Module"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://${S}/GPL-COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://${S}/MIT-COPYING;md5=fea016ce2bdf2ec10080f69e9381d378 \
"

inherit module

RENESAS_CPURTTDRV_URL ?= "git://github.com/renesas-rcar/cpurttdrv2.git"
SRCREV = "301cef03b89dc3f074f4985effd6e85f83564ccd"

SRC_URI = "${RENESAS_CPURTTDRV_URL};nobranch=1"

S = "${WORKDIR}/git"

PR = "r0"
PV = "0.1"

libmoduledir = "/lib/modules/5.4.72-yocto-standard/extra/"

do_install () {
    install -d ${D}${libmoduledir}
    install -d ${D}${includedir}/kernel-module-cpurttdrv2/v3h1
    install -d ${D}${includedir}/kernel-module-cpurttdrv2/v3h2
    install -d ${D}${includedir}/kernel-module-cpurttdrv2/v3m2
    install -m 775 ${S}/v3h1/cpurttmod2_v3h1.ko ${D}${libmoduledir}
    install -m 775 ${S}/v3h2/cpurttmod2_v3h2.ko ${D}${libmoduledir}
    install -m 775 ${S}/v3m2/cpurttmod2_v3m2.ko ${D}${libmoduledir}
    install -m 644 ${S}/v3h1/Module.symvers ${D}${includedir}/kernel-module-cpurttdrv2/v3h1
    install -m 644 ${S}/v3h2/Module.symvers ${D}${includedir}/kernel-module-cpurttdrv2/v3h2
    install -m 644 ${S}/v3m2/Module.symvers ${D}${includedir}/kernel-module-cpurttdrv2/v3m2

    install -d ${D}${prefix}/local/include/cpurttmod2_v3h1
    install -d ${D}${prefix}/local/include/cpurttmod2_v3h2
    install -d ${D}${prefix}/local/include/cpurttmod2_v3m2
    install -m 644 ${S}/v3h1/cpurtt_common.h ${D}${prefix}/local/include/cpurttmod2_v3h1
    install -m 644 ${S}/v3h2/cpurtt_common.h ${D}${prefix}/local/include/cpurttmod2_v3h2
    install -m 644 ${S}/v3m2/cpurtt_common.h ${D}${prefix}/local/include/cpurttmod2_v3m2
}

FILES_${PN}-dev = " \
    ${includedir}/kernel-module-cpurttdrv2 \
    ${prefix}/local/include/cpurttmod2_v3h1 \
    ${prefix}/local/include/cpurttmod2_v3h2 \
    ${prefix}/local/include/cpurttmod2_v3m2 \
"

KERNEL_MODULE_PROBECONF += "cpurttmod2_v3h1 cpurttmod2_v3h2 cpurttmod2_v3m2"
module_conf_cpurttmod2_v3h1 = "blacklist cpurttmod2_v3h1"
module_conf_cpurttmod2_v3h2 = "blacklist cpurttmod2_v3h2"
module_conf_cpurttmod2_v3m2 = "blacklist cpurttmod2_v3m2"


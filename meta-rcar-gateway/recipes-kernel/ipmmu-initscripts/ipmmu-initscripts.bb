DESCRIPTION = "Initscript for PCIe IPMMU performance"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://set-ipmmu-irq.sh"

S = "${WORKDIR}"

INITSCRIPT_NAME = "set-ipmmu-irq.sh"

inherit update-rc.d

do_compile[noexec] = "1"

do_install () {
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/set-ipmmu-irq.sh ${D}${sysconfdir}/init.d/
}


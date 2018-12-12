DESCRIPTION = "Firmware files for TI Bluetooth Chips"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f39eac9f4573be5b012e8313831e72a9 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# This recipe provides the latest firmware files for wl18xx.
# Therefore, use the contents of this recipe instead of the contents
PR = "r0+gitr${SRCREV}"
COMPATIBLE_MACHINE = "udooneo"

SRCREV = "31a43dc1248a6c19bb886006f8c167e2fd21cb78"
SRC_URI = "git://git.ti.com/ti-bt/service-packs.git"

S = "${WORKDIR}/git"
do_compile() {
    :
}

do_configure() {
    :
}


do_install() {
    install -d ${D}${base_libdir}/firmware
    oe_runmake 'DEST_DIR=${D}' 'BASE_LIB_DIR=${base_libdir}' install
}

FILES_${PN} += "${base_libdir}/firmware"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/:"

#mkimage as host tool is required to build boot.scr
DEPENDS_append_udooneo = " ${PN}-mkimage-native"

SRC_URI_append_udooneo =" \
	 file://boot.scr.txt \
	 file://0001-Support-bootaux-command.patch \
	 file://0003-Enable-Logging.patch \
	 "

do_compile_append_udooneo () {
    echo "generating boot.scr for udoo neo"
    mkimage -A ${TARGET_ARCH} -T script -C none -d ${WORKDIR}/boot.scr.txt ${WORKDIR}/boot.scr
}

do_install_append_udooneo () {
    echo "installing boot.scr previously generated..."
    install -m 0644 ${WORKDIR}/boot.scr ${D}/boot/
    #mkdir -p ${DEPLOYDIR}
    #install -m 0644 ${WORKDIR}/boot.scr ${DEPLOYDIR}/
}

PACKAGES_prepend_udooneo = "${PN}-bootscript "
FILES_${PN}-bootscript_udooneo = "/boot/boot.scr"

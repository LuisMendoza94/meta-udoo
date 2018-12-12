inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "\
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=git;name=machine;branch=linux-4.19.y \
	file://defconfig \
	file://0001-Added-Brick-Sensors-for-UDOO-Neo-on-i2c-bus.patch \
	file://0002-imx6sx-udoo-neo.dtsi-add-required-pinctrl-informatio.patch \
	file://0003-bluetooth-Enable-bluetooth-on-serial-port-using-HCI_.patch \
	"

LINUX_VERSION ?= "4.19.7"
LINUX_VERSION_EXTENSION_append = "-udooneo"

# expand the defconfig file so that all variables are correctly set
KCONFIG_MODE = "--alldefconfig"

SRCREV_machine="v${LINUX_VERSION}"

PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "(^udooneo$)"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

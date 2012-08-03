DESCRIPTION = "Writes a loader binary to a OneNAND/NAND flash memory device"
HOMEPAGE = "http://www.isee.biz"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://writeloader.c;beginline=7;endline=15;md5=8741a55a49e72d63dd8b059b971ef9fb"

SRCREV="1361fca1fe13dafe9cd05ab627685b59af868e42"

PV = "0.1+git${SRCPV}"
PR = "r0"

SRC_URI = "git://git.isee.biz/pub/scm/writeloader.git;protocol=git"
SRC_URI += "file://0001-rename-MTD_MODE_RAW-to-MTD_FILE_MODE_RAW-for-compati.patch"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/writeloader ${D}${bindir}/writeloader
}

S = "${WORKDIR}/git"

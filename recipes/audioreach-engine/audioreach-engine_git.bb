SUMMARY = "AudioReach Engine"
HOMEPAGE = "https://github.com/Audioreach/audioreach-engine"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e05239e7fcd8a11aa1cf053559a95430"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
SRC_URI = "git://github.com/Audioreach/audioreach-engine.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

#https://stackoverflow.com/questions/61473077/didnt-pass-ldflags-ldflags
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile[progress] = "percent"

EXTRA_OECMAKE += "-DARCH=linux -DCONFIG=defconfig"

LDFLAGS:append = " -pthread -lar-gpr -ltinyalsa"

inherit cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"

DEPENDS = "glib-2.0 audioreach-graphservices tinyalsa"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

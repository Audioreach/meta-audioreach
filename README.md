# meta-audioreach
This repository hosts OpenEmbedded meta layer for AudioReach

# OpenEmbedded Build & Development Process
This instruction assumes reader has general understanding and environment setup for OpenEmbedded build

## Placing meta layer in OpenEmbedded build

### Get meta layer

Assume openEmbedded build is being synced to <path_to_openEmbdded_build>,
``` bash
cd <path_to_openEmbdded_build>/layers
git clone https://github.com/Audioreach/meta-audioreach.git
```

### Add meta layer to bblayers.conf
- Find bblayers.conf. It is likely to be at this path <path_to_openEmbdded_build>/conf/conf/bblayers.conf
- Append ${OEROOT}/layers/meta-audioreach to the BBLAYERS path

## Include AudioReach components as part of system image
- Find local.conf. Likely to be present at this path <path_to_openEmbdded_build>/conf/conf/local.conf.
- Append line:
```
IMAGE_INSTALL:append = "audioreach-kernel audioreach-graphservices tinyalsa audioreach-graphmgr"
```

### Kick-off build process
Select desired machine to build for and kick off compilation process for desired image

```bash
source setup-environment
bitbake <target-image>
```
## License
meta-audioreach is licensed under the MIT License. Check out the [LICENSE](LICENSE) for more details
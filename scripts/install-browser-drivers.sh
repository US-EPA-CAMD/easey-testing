#!/bin/bash
set -eo pipefail
cd /usr/bin
apt-get install -y wget
wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
apt-get install ./google-chrome-stable_current_amd64.deb

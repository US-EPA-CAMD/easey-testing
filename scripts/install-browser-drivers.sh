#!/bin/bash

# Variables
chrome_version="latest"
chrome_url="https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb"
chromedriver_url="https://chromedriver.storage.googleapis.com/LATEST_RELEASE"
install_dir="/opt"
drivers_dir="/home/runner/drivers"

# Download and install Google Chrome
echo "Downloading Google Chrome..."
wget -q --show-progress -O /tmp/google-chrome.deb $chrome_url

echo "Installing Google Chrome..."
sudo dpkg -i /tmp/google-chrome.deb
sudo apt-get -qq -f install

# Download ChromeDriver
echo "Downloading ChromeDriver..."
version=$(curl -s $chromedriver_url)
wget -q --show-progress -O /tmp/chromedriver_linux64.zip "https://chromedriver.storage.googleapis.com/$version/chromedriver_linux64.zip"

# Install ChromeDriver
echo "Installing ChromeDriver..."
sudo unzip -q /tmp/chromedriver_linux64.zip -d $install_dir
sudo chmod +x $install_dir/chromedriver
sudo mv $install_dir/chromedriver $drivers_dir/chromedriver
sudo ln -sf $drivers_dir/chromedriver /usr/local/bin/chromedriver

echo "Chrome and ChromeDriver installation completed."

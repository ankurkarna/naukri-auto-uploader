import requests
import os

# API endpoint (replace with your user profile id if different)
url = "https://www.naukri.com/cloudgateway-mynaukri/resman-aggregator-services/v0/users/self/profiles/cb2dd093eb56f31bee82190ebad747dede6f606e851cda08fcc93b141dd0abb8/advResume"

headers = {
    "authorization": os.environ["NAUKRI_AUTH"],
    "x-http-method-override": "PUT",
    "appid": "105",
    "systemid": "105",
    "user-agent": "Mozilla/5.0",
}

files = {
    "file": ("AnkurKarna_Resume.pdf", open("resume/AnkurKarna_Resume.pdf", "rb"), "application/pdf")
}

response = requests.post(url, headers=headers, files=files)

print("Status:", response.status_code)
print("Response:", response.text)

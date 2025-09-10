import os
import requests

cookies = {
    "nauk_at": os.getenv("NAUK_AT"),
    "nauk_otl": os.getenv("NAUK_OTL"),
    "MYNAUKRI[UNID]": os.getenv("NAUK_UNID"),
    "NKWAP": os.getenv("NKWAP"),
    "PS": os.getenv("PS"),
    "is_login": os.getenv("IS_LOGIN"),
}

files = {
    "uploadCv": open("resume/AnkurKarna_Resume.pdf", "rb")
}

url = "https://www.naukri.com/mnjuser/profile/upload-cv"

res = requests.post(url, cookies=cookies, files=files)

print("Status:", res.status_code)
print("Response (first 500 chars):")
print(res.text[:500])

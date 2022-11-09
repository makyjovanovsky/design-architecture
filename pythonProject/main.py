import numpy as np
import pandas as pd
import requests
from bs4 import BeautifulSoup
from IPython.display import HTML
import warnings

if __name__ == '__main__':
    requests.packages.urllib3.disable_warnings()
    warnings.filterwarnings("ignore")
    url = "https://makpetrol.com.mk/MapSearch/"
    response = requests.get(url)
    raw_html = response.text
    html = BeautifulSoup(raw_html, "html.parser")
    gas_stations = html.select(".table_parent_item")
    gas_stations_names = []
    gas_stations_working_hours = []
    gas_stations_locations = []
    gas_stations_phone_number = []
    for i in range(0, len(gas_stations)):
        gas_stations_names.append(gas_stations[i].select("td")[0].text)
        gas_stations_working_hours.append(gas_stations[i].select("td")[1].text)
        gas_stations_locations.append(gas_stations[i].select("td")[2].text)
        gas_stations_phone_number.append(gas_stations[i].select("td")[3].text)

    data = []
    for i in range(0, len(gas_stations)):
        item = {'Name': gas_stations_names[i], 'Working Hours': gas_stations_working_hours[i],
                'Location': gas_stations_locations[i], 'Phone Number': gas_stations_phone_number[i]}
        data.append(item)

    df = pd.DataFrame(data)
    df.to_csv("D:\\Semestar V\\Dizajn i arhitektura na softver\\Labaratoriski Vezbi\\dataset.csv", encoding="utf-8-sig")

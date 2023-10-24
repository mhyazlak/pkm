import requests

dexNumber = 493
api_base_url = "https://pokeapi.co/api/v2/pokemon/"
output_file = "V1_2__INSERT_POKEMON.sql"

# Create or open the SQL file for writing
with open(output_file, "w") as sql_file:
    for pokemon_id in range(1, dexNumber + 1):
        api_url = f"{api_base_url}{pokemon_id}"
        response = requests.get(api_url)

        if response.status_code == 200:
            data = response.json()
            pokemon_name = data["name"]

            # Write the SQL insert statement with id and name to the file
            sql_statement = f"INSERT INTO Pokemon (id, name) VALUES ({pokemon_id}, '{pokemon_name}');\n"
            sql_file.write(sql_statement)
        else:
            print(f"Failed to fetch data for Pokemon with ID {pokemon_id}")

print(f"SQL insert statements have been written to {output_file}")

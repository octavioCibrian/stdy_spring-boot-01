```toml
name = 'Add verify Email'
method = 'POST'
url = 'http://localhost:8080/users/emailVerified'
sortWeight = 5000000
id = 'a8d3f96f-22f8-49ab-ae79-9a02e396418d'

[body]
type = 'JSON'
raw = '''
{
  "name": "Octavio",
  "email": "octavio.cibrian@gmail.com"
}'''
```

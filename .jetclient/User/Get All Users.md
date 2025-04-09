```toml
name = 'Get All Users'
method = 'GET'
url = 'http://localhost:8080/users'
sortWeight = 2000000
id = '6052e08b-b7e3-441a-b57d-851e5a9d6578'

[auth]
type = 'NO_AUTH'

[body]
type = 'JSON'
raw = '''
{
  "name": "octavio",
  "email": "octavio.cibrian@gmail.com"
}'''
```

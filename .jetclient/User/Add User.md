```toml
name = 'Add User'
method = 'POST'
url = 'http://localhost:8080/users'
sortWeight = 1000000
id = 'baadd17f-6c7c-4e28-b5c2-3e0923c42461'

[auth.bearer]
token = 'eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJvUzhNaHAtbjFZMVBlM0N0NTMxRG1EMFFTLVNISXliQThpQXNqbEE5SXFJIn0.eyJleHAiOjE3NDQyMDIwMjQsImlhdCI6MTc0NDIwMTcyNCwianRpIjoiZjc0ODEyOTAtYWY4ZS00YjNiLWFjZjEtOTg1OWM2NjUyMGQxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgwL3JlYWxtcy9Cb29rU3RvcmVSZWFsbSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIxZDA1Mjk3Ni0xZjg2LTRjOGQtODgyYi1jZDcwNzk3YThjNjciLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJib29rc3RvcmUtY2xpZW50Iiwic2lkIjoiZWZkYmM0MTktOWZjMi00ZjIxLThmMWEtYzNhYjY3ODUyZDIzIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vbG9jYWxob3N0OjgwODAiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiYWRtaW4iLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtYm9va3N0b3JlcmVhbG0iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJPY3RhdmlvIENpYnJpYW4iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiIsImdpdmVuX25hbWUiOiJPY3RhdmlvIiwiZmFtaWx5X25hbWUiOiJDaWJyaWFuIiwiZW1haWwiOiJvY3RhdmlvLmNpYnJpYW5AZ21haWwuY29tIn0.Y5SvDFWdATuRBnkOhjsyf4-jX4xmlge27Bl--3mC3b757PdG9fydqSPeX-0mo_wwQDGPnbwMrXsDpfJgYKW9GsZ42DeYTREDN05Hu4Sn7CSvPvJBJIcneD7SSUuud-HED7WZX-jLm2Ja9xlOqnW13EoqagO-qAqBuBG0p_YhqhkSM3z4bL7GRuJON-NQ7FULkyCJtTSNJk8L33bR7M72xQfZa1OoB1liLYI9o7HLiFthwmM6jEpWCbiXrnZlRwpSrjctmmtqT62ePmlXwOS37akZfme2O3ouSWycKmDMhoBy1IwSJjypvuwsfj2dcCpgEKNnm1Fg2qclxliXhoO4Wg'

[body]
type = 'JSON'
raw = '''
{
  "name": "octavio",
  "email": "octavio.cibrian@gmail.com"
}'''
```

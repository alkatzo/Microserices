
# Authentication Flow and Auth0 Integration

## Overview
This project uses a microservices architecture with two main services: `users` (frontend) and `auth` (authentication backend). Authentication is handled via Auth0 (by Okta) using OAuth2/OpenID Connect.

## How Authentication Works
1. The user accesses the users service (http://localhost:8081).
2. The users service redirects the user to the auth service (http://localhost:8082/oauth2/authorization/okta) to start authentication.
3. The auth service uses Spring Security OAuth2 to redirect the user to Auth0's login page.
4. The user logs in with Auth0 (can use email/password, Google, or other enabled providers).
5. Auth0 authenticates the user and redirects back to the auth service at `/login/oauth2/code/okta`.
6. The auth service processes the login and redirects the user to the main page in the users service (http://localhost:8081/main).

## Auth0 Integration Details
- Auth0 Domain: alkatzo.au.auth0.com
- Client ID: p9JbwwJMHEuARzQr2P4D6JSGpQFVi43I
- Client Secret: idSpbY8kveX0oF9sOY3QqEbUhYLTlO6Td2dOEwOqQ7qNTxF15-M50BxigtpdsX5k
- Allowed Callback URL: http://localhost:8082/login/oauth2/code/okta
- The auth service is configured to use Auth0 as an OAuth2 provider in its `application.yml`.

## Notes
- The users service does not handle authentication directly; it delegates to the auth service.
- Auth0 can federate with social providers (like Google) or use its own database connection for user credentials.
- After login, the user is redirected to the main page in the users service.

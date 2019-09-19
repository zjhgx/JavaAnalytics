8.1.3 Authentication
What is authentication in Spring Security?
Let’s consider a standard authentication scenario that everyone is familiar with.

A user is prompted to log in with a username and password.
The system (successfully) verifies that the password is correct for the username.
The context information for that user is obtained (their list of roles and so on).
A security context is established for the user
The user proceeds, potentially to perform some operation which is potentially protected by an access control mechanism which checks the required permissions for the operation against the current security context information.
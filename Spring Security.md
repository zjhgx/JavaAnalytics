## Spring Security Architecture

#### Authentication and Access Control
Application security boils down to two more or less independent problems: authentication (who are you?) and authorization (what are you allowed to do?). Sometimes people say "access control" instead of "authorization" which can get confusing, but it can be helpful to think of it that way because "authorization" is overloaded in other places. Spring Security has an architecture that is designed to separate authentication from authorization, and has strategies and extension points for both.


8.1.3 Authentication
What is authentication in Spring Security?
Let’s consider a standard authentication scenario that everyone is familiar with.

A user is prompted to log in with a username and password.
The system (successfully) verifies that the password is correct for the username.
The context information for that user is obtained (their list of roles and so on).
A security context is established for the user
The user proceeds, potentially to perform some operation which is potentially protected by an access control mechanism which checks the required permissions for the operation against the current security context information.
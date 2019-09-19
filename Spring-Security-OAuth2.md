## OAuth 2.0 Provider
The OAuth 2.0 provider mechanism is responsible for exposing OAuth 2.0 protected resources. The configuration involves establishing the OAuth 2.0 clients that can access its protected resources independently or on behalf of a user. The provider does this by managing and verifying the OAuth 2.0 tokens used to access the protected resources. Where applicable, the provider must also supply an interface for the user to confirm that a client can be granted access to the protected resources (i.e. a confirmation page).

## OAuth 2.0 Provider Implementation
The provider role in OAuth 2.0 is actually split between Authorization Service and Resource Service, and while these sometimes reside in the same application, with Spring Security OAuth you have the option to split them across two applications, and also to have multiple Resource Services that share an Authorization Service. The requests for the tokens are handled by Spring MVC controller endpoints, and access to protected resources is handled by standard Spring Security request filters. The following endpoints are required in the Spring Security filter chain in order to implement OAuth 2.0 Authorization Server:
* AuthorizationEndpoint is used to service requests for authorization. Default URL: /oauth/authorize.
* TokenEndpoint is used to service requests for access tokens. Default URL: /oauth/token.
The following filter is required to implement an OAuth 2.0 Resource Server:

* The OAuth2AuthenticationProcessingFilter is used to load the Authentication for the request given an authenticated access token.

## Authorization Server Configuration
As you configure the Authorization Server, you have to consider the grant type that the client is to use to obtain an access token from the end-user (e.g. authorization code, user credentials, refresh token). The configuration of the server is used to provide implementations of the client details service and token services and to enable or disable certain aspects of the mechanism globally. Note, however, that each client can be configured specifically with permissions to be able to use certain authorization mechanisms and access grants. I.e. just because your provider is configured to support the "client credentials" grant type, doesn't mean that a specific client is authorized to use that grant type.

The @EnableAuthorizationServer annotation is used to configure the OAuth 2.0 Authorization Server mechanism, together with any @Beans that implement AuthorizationServerConfigurer (there is a handy adapter implementation with empty methods). The following features are delegated to separate configurers that are created by Spring and passed into the AuthorizationServerConfigurer:
* ClientDetailsServiceConfigurer: a configurer that defines the client details service. Client details can be initialized, or you can just refer to an existing store.
* AuthorizationServerSecurityConfigurer: defines the security constraints on the token endpoint.
* AuthorizationServerEndpointsConfigurer: defines the authorization and token endpoints and the token services.
An important aspect of the provider configuration is the way that an authorization code is supplied to an OAuth client (in the authorization code grant). A authorization code is obtained by the OAuth client by directing the end-user to an authorization page where the user can enter her credentials, resulting in a redirection from the provider authorization server back to the OAuth client with the authorization code. Examples of this are elaborated in the OAuth 2 specification.

#### Configuring Client Details

The ClientDetailsServiceConfigurer (a callback from your AuthorizationServerConfigurer) can be used to define an in-memory or JDBC implementation of the client details service. Important attributes of a client are

* 
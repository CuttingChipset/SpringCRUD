## DISCLAIMER

The project currently does not work as intended, due to a configuration error that despite my attempts,
has not been resolved. Please advise on how to fix `java.lang.NoClassDefFoundError: javax.xml.bind.annotation.XmlRootElement`.

# SpringCRUD

A basic Java Spring application that supports CRUD operations, thanks to connection with an internal H2 database.

Requires Java 21 to function.

### Available HTTP API requests

- GET `/api/v1/products/list` - Lists all available products
- GET `/api/v1/products/{id}` - Find the specific product
- POST `/api/v1/products/create` - Create a new product
- PUT `/api/v1/products/update/{id}` - Update the product
- DELETE `/api/v1/products/delete/{id}` - Delete the product
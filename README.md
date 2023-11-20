
# TranSped

TranSped is a REST API for Spedition Company.  

## Demo

[Link](http://16.171.235.79/swagger-ui/index.html#/)


## Deployment

Application is deployed on AWS EC2.

Database works on AWS RDS.



## Tech Stack

**Spring:** Boot, Data, Security

**Database:** PostgreSQL

**Cloud:** AWS EC2, AWS RDS

**Tools:** Maven, SwaggerUI(OpenAPI), docker 


## Instruction

To use REST API, first you need to login by /login endpoint using credentials listed below:

**ADMIN:** login: admin@admin.pl password: admin

**SPEDITOR:** login: speditor@speditor.pl password: speditor

**CLIENT:** login: client@client.pl password: client

**DRIVER:** login: driver@driver.pl password: driver

Then, you have to copy token from the responce and paste it in Authorize button.

Now, you can access other endpoints depends on your account (check security below).
## Security

REST API is secured by JWT authentication.

There are 4 roles:

**Admin:** can access everything.

**Speditor:** can access everything except adding, editing or deleting parcels.

**Client:** can only add, edit or delete parcels.
 
**Driver:** can only check deliveries.
# TransitHub Function App

## Naming Convention

We want to have very consistent by having a naming convention to prevent confusion of different way of naming.  
Only the following naming are considered valid for the project `206566`, with descending priority.  
Use the next naming IFF the current one is not supported or not suitable for the given environment.  

1. TransitHub
2. transithub
3. transit_hub

### Always Singular, No Plural

When hesitating between `event` or `events`, `message` or `messages`, always use `singular`.  

### Always Full name, No Abbreviation

Use `EnvironmentVariable` as always, no abbreviation like `EnvVar` is allowed.  

## Useful command 

### Login Azure

```bash
az login
```

### List azure account available

```bash
az account list
```

### Set default subscription

```bash
az account set --subscription <id or name>
```

## Useful script

```bash
source configuration/script/function.sh
azure-run    # run locally
azure-deploy # deploy to azure, make sure you have correct subscription id as default
```

## Send Test Data

This will send test data to ingestor, and thus will pass to EventHub, eventually triggers the validator.  

```bash
curl -d'Rugal Bernstein' 'http://localhost:7071/api/ingestor'
curl -d'{"createdBy":"Stephanie.Chen.v9m","createDate":"Dec 10, 2019 2:33:10 PM","updatedBy":"Stephanie.Chen.v9m","updateDate":"Dec 10, 2019 2:33:10 PM","entity":{"id":"5defaca6440a310c1c6a3b1a","code":"steph_code_5","versionId":196008,"clientId":2,"tenantId":2}}' \
  'http://localhost:7071/api/ingestor'
```

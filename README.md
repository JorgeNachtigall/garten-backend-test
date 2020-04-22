# Back-end Garten Test

## Informações

### Connection

Dentro da classe Connection é necessário modificar o DATABASE_URL para um diretório válido no seu computador.

## Endpoints

**Tweets**
----
 Retorna um objeto contendo um campo 'status', que pode ser "SUCCESS" ou "ERROR", e um campo 'data' que retorna um array contendo todos os tweets ou um objeto vazio caso não haja nenhum tweet registrado. 

* **URL**

  /tweets

* **Method:**

  `GET`

*  **Headers**

	 `Content-Type: application/json`
	 

*  **URL Params**

	Nenhum

* **Body Params**

	Nenhum
	
* **Success Response:**

    **Content:** 
    ```javascript
    {
       "status": "SUCCESS",
		"data": [
            {
                "id": 1,
                "author": "Jorge0",
                "content": "alienum veritus contentiones viris aperiri ligula option scripserit labores",
            },
            {
                "id": 2,
                "author": "Luis1",
                "content": "alienum s contentiones vi aperiri ligla ocriprit ores",
            },
        ]
    }
    ```

**Resgatar tweet pelo ID**
----
 Retorna um objeto contendo um campo 'status', que pode ser "SUCCESS" ou "ERROR", e um campo 'data' que retorna um objeto contendo o tweet associado ao ID em caso dele existir ou um objeto vazio caso contrário.

* **URL**

  /tweet/:id

* **Method:**

  `GET`
  
*  **Headers**

	 `Content-Type: application/json`
	 
*  **URL Params**

	 :id - ID de um tweet

* **Body Params**

     Nenhum
	
* **Success Response:**

    **Content:** 
    ```javascript
    {
       "status": "SUCCESS",
	   "data":{
                "id": 1,
                "author": "Jorge0",
                "content": "alienum veritus contentiones viris aperiri ligula option scripserit labores",
            }
    }
    ```

**Mostrar todas as replies de um tweet através do seu ID**
----
 Retorna um objeto contendo um campo 'status', que pode ser "SUCCESS" ou "ERROR", e um campo 'data' que retorna um objeto contendo o tweet associado ao ID em caso dele existir ou um objeto vazio caso contrário.

* **URL**

  /tweet/:id/replies

* **Method:**

  `GET`
  
*  **Headers**

	 `Content-Type: application/json`
	 
*  **URL Params**

	 :id - ID de um tweet

* **Body Params**

	Nenhum
	
* **Success Response:**

    **Content:** 
    ```javascript
    {
        "status": "SUCCESS",
        "data": [{
            "id": 1,
            "author": "Dummy0",
            "content": "aptent comprehensam agam ornare mei omnesque urbanitas sanctus",
        }]
    }
    ```

**Criar um tweet**
----
 Retorna um objeto contendo um campo 'status' e um campo 'message'. 

* **URL**

  /tweet

* **Method:**

  `POST`
  
*  **Headers**

	 `Content-Type: application/json`
	 
*  **URL Params**

    Nenhum

* **Body Params**

	`author`: Nome do autor,
	`content`: Conteúdo do tweet
	
* **Success Response:**

    **Content:** 
    ```javascript
    {
        "status": "SUCCESS",
        "message": "Tweet created with success"
    }
  ```
 
* **Error Response:**


    **Content:**    
    ```javascript
    {
      {
        "status": "ERROR",
        "message": "Can't create the requested tweet"
    }
    }
    ```

* **Body Sample Call:**

    ```javascript
	{
        "author": "Jorge",
        "content": "Lorem ipsum",
    }
    ```

**Criar uma reply para um tweet através do seu ID**
----
 Retorna um objeto contendo um campo 'status' e um campo 'message'.  

* **URL**

  /tweet/:id/reply

* **Method:**

  `POST`
  
*  **Headers**

	 `Content-Type: application/json`
	 
*  **URL Params**

	 :id - ID de um tweet

* **Body Params**

	`author`: Nome do autor
	`content`: Conteúdo do tweet
	
* **Success Response:**

    **Content:** 
    ```javascript
    {
        "status": "SUCCESS",
        "message": "Reply created with success"
    }
  ```
 
* **Error Response:**


    **Content:**    
    ```javascript
    {
    
        "status": "ERROR",
        "message": "Can't create the requested reply"   
    }
    ```

* **Body Sample Call:**

   ```javascript
   {
        "author": "Jorge",
        "content": "Lorem ipsum",
    }
  ```

import requests
from fastapi import FastAPI
from pydantic import BaseModel
from contextlib import asynccontextmanager
from apscheduler.triggers.interval import IntervalTrigger
from apscheduler.schedulers.asyncio import AsyncIOScheduler

scheduler = AsyncIOScheduler()

pagamentos = []

async def return_pagamento():
    tamanho_lista = len(pagamentos)
    if tamanho_lista > 0:
        for pagamento in pagamentos:
            id_pedido = pagamento
            url = 'http://app:8080/webhook/payment'
            payload = {"status": "APROVADO", "id_pedido": id_pedido}
            print(f"Chamando webhook para o pedido {id_pedido}")
            response = requests.post(url, json=payload)
            print(f"Status Code: {response.status_code}, Response: {response.content}")
            pagamentos.remove(pagamento)
    else:
        print("Webhook: Nenhum pedido a ser processado.")

scheduler.add_job(return_pagamento, IntervalTrigger(seconds=10))

@asynccontextmanager
async def lifespan(app: FastAPI):
    scheduler.start()
    yield
    scheduler.shutdown()

app = FastAPI(lifespan=lifespan)

class Pagamento(BaseModel):
    id_pedido: int
    valor_total: float

@app.post("/pagamento/processar")
def read_item(pagamento: Pagamento):
    pagamentos.append(pagamento.id_pedido)
    return {"status": "Processando", "pedidoId": pagamento.id_pedido}


if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=9091)
    
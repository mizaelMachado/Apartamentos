<template>
    <div class="listar">
        <fieldset>
            <legend> Listar Apartamentos</legend>
            Quantidade de apartamentos: <input type="number" name="quantidade" v-model="quantidade">
            <button @click="pegar">Buscar Todos</button>
            <button @click="pegarQTD">Buscar</button><br />
            Endereco: <input type="text" name="endereco" v-model="endereco" />
            <button @click="pegarEndereco">Buscar</button><br />
            Data da Postagem: <input type="date" name="data" v-model="data" max="2020-11-04">  <br />
            <button @click="pegarData">Buscar Data</button><br />
            Buscar por aluguel ate: <input type="number" name="valor" v-model="valor">  <br />
            <button @click="pegarValor">Buscar Valor</button><br />
            <fieldset>
                <legend>Filtrar por Aluguel</legend>
                Limite inferior: <input type="number" name="inferior" v-model="inferior">  <br />
                Limite superior: <input type="number" name="superior" v-model="superior">  <br />

                <button @click="pegarLimite">Buscar</button><br />
            </fieldset>
            <fieldset>
                <legend>Filtrar por Aluguel e Condominio</legend>
                Limite inferior Aluguel: <input type="number" name="inferior" v-model="inferior">  <br />
                Limite superior Aluguel: <input type="number" name="superior" v-model="superior">  <br />
                Limite inferior Condominio: <input type="number" name="inferiorCondominio" v-model="inferiorCondominio">  <br />
                Limite superior Condominio: <input type="number" name="superiorCondominio" v-model="superiorCondominio">  <br />
                <button @click="pegarLimite2">Buscar</button><br />
            </fieldset>
            <ul>
                <li v-for="apartamento in apartamentos" :key="apartamento.id">
                    <fieldset class="fieldApartamentos">
                        <legend><h3>{{ apartamento.endereco }}</h3></legend>
                        id: <p> {{ apartamento.id}}</p>
                        valor aluguel: <p>{{ apartamento.valorAluguel }}</p>
                        quantidade de quartos: <p>{{ apartamento.quantidadeQuartos }}</p>
                        quantidade de vagas na garagem: <p>{{ apartamento.quantidadeVagasGaragem }}</p>
                        valor Condominio: <p>{{ apartamento.valorCondominio }}</p>
                        data de postagem: <p>{{ apartamento.dataPostagem }}</p>
                    </fieldset>
                </li>

            </ul>

        </fieldset>
    </div>
</template>
<script>export default {
    name: 'FormFuncionario',
    data () {
        return {
            quantidade: null,
            endereco: null,
            data: null,
            valor: null,
            inferior: null,
            superior: null,
            inferiorCondominio: null,
            superiorCondominio: null,
            apartamentos: [],
          
         }
        },
        
  methods:{
    pegar: function() {
        this.axios
        .get('http://localhost:5000/api/apartamentos')
        .then(response => {
            this.apartamentos = response.data;
        })
        .catch(error => {
            console.log(error)
            console.log('erro ao solicitar apartamentos');
        });
    },
       pegarQTD: function() {
        this.axios
            .get('http://localhost:5000/api/apartamentos/search1'+ "?quantidade=" + this.quantidade)
        .then(response => {
            this.apartamentos = response.data;
        })
        .catch(error => {
            console.log(error)
            console.log('erro ao solicitar apartamentos por quantidade definida');
        });
      },
      pegarEndereco: function () {
          this.axios
              .get('http://localhost:5000/api/apartamentos/search2' + "?endereco=" + this.endereco)
              .then(response => {
                  this.apartamentos = response.data;
              })
              .catch(error => {
                  console.log(error)
                  console.log('erro ao solicitar apartamentos por quantidade definida');
              });
      },
      pegarData: function () {
          data: new Date(this.data)
          this.axios
              .get('http://localhost:5000/api/apartamentos/search3' + "?data=" + this.data)
              .then(response => {
                  this.apartamentos = response.data;
              })
              .catch(error => {
                  console.log(error)
                  console.log('erro ao solicitar apartamentos por quantidade definida');
              });
      },
      pegarValor: function () {
          this.axios
              .get('http://localhost:5000/api/apartamentos/search4' + "?valor=" + this.valor)
              .then(response => {
                  this.apartamentos = response.data;
              })
              .catch(error => {
                  console.log(error)
                  console.log('erro ao solicitar apartamentos por quantidade definida');
              });
      },
      pegarLimite: function () {
          this.axios
              .post('http://localhost:5000/api/apartamentos/search5',{
                  inferior: this.inferior,
                  superior: this.superior
              })
              .then(response => {
                  this.apartamentos = response.data;
              })
              .catch(error => {
                  console.log(error)
                  console.log('erro ao solicitar apartamentos por quantidade definida');
              });
      },
      pegarLimite2: function () {
          this.axios
              .post('http://localhost:5000/api/apartamentos/search6', {
                  inferior: this.inferior,
                  superior: this.superior,
                  inferiorCondominio: this.inferiorCondominio,
                  superiorCondominio: this.superiorCondominio
              })
              .then(response => {
                  this.apartamentos = response.data;
              })
              .catch(error => {
                  console.log(error)
                  console.log('erro ao solicitar apartamentos por quantidade definida');
              });
      },
  }

}</script>
<style>

    .fieldApartamentos {
        padding: 10%;
    }
</style>
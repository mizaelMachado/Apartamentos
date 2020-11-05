<template>
    <div>
        <form   action="checkForm"
                method="post"
                novalidate="true" >
            <fieldset>
                <legend>Cadastro Apartamento</legend>
                <p v-if="errors.length" class="alert alert-danger" role="alert">
                    <b>Por favor, corrija o(s) seguinte(s) erro(s):</b>
                    <ul>
                        <li v-for="error in errors" class="alert alert-danger" role="alert">{{ error }}</li>
                    </ul>
                </p>

                Endereco: <input type="text" v-model="endereco" name="endereco" /> <br />
                Quantidade de Quartos: <input type="number" v-model="quantidadeQuartos" name="quantidadeQuartos" min="1" /> <br />
                Quantidade de Vagas na Garagem: <input type="number" v-model="quantidadeVagasGaragem" name="quantidadeVagasGaragem" min="1" /><br />
                Valor do Aluguel: <input type="number" v-model="valorAluguel" name="valorAluguel" min="1" /><br />
                Valor do condominio:  <input type="number" v-model="valorCondominio" name="valorCondominio" /><br />
                Imagem do apartamento:    <input type="file" id="file"  ref="file"  name="image"    @change="upload" /> <br />
                Data da Postagem: <input type="date" name="dataPostagem" v-model="dataPostagem" max="2020-11-04" required>  <br />
                <button type="button" @click="adicionar">Salvar</button><input type="reset" value="Apagar" />
            </fieldset>
        </form>
    </div>
</template>

<script>

	

export default {
  name: 'FormApartamento',
	
	 data (){
         return {
            id:0,
            endereco: '',
			quantidadeQuartos: 0,
            quantidadeVagasGaragem: 0,
            valorAluguel: 0.0,
            valorCondominio: 0.0,
            dataPostagem: '',
            file: null,
            apartamento: {},
            errors: []
        }
    },
    methods :{
        async adicionar() {
            this.errors = [];

            if (!this.endereco) {
                this.errors.push('O endereco e obrigatorio.');
               
            }
            if (!this.quantidadeQuartos) {
                this.errors.push('Quantidade de quartos e obrigatorio.');
             
            }
            if (!this.quantidadeVagasGaragem) {
                this.errors.push('Quantidade de vagas na garagem e obrigatorio.');
           
            }
            if (!this.valorAluguel) {
                this.errors.push('valor do aluguel e obrigatorio.');
               
            }
            if (!this.dataPostagem) {
                this.errors.push('data da postagem  e obrigatorio.');
               
            }
            if (this.endereco.length < 5) {
                this.errors.push('Utilize um tamanho de endereco valido,acima de 5 caracteres.');
            
            }

            if (this.errors.length) {
                return true;
            } else {
                await this.axios
                    .post("http://localhost:5000/api/apartamentos", {
                        endereco: this.endereco,
                        quantidadeQuartos: this.quantidadeQuartos,
                        quantidadeVagasGaragem: this.quantidadeVagasGaragem,
                        valorAluguel: this.valorAluguel,
                        valorCondominio: this.valorCondominio,
                        dataPostagem: new Date(this.dataPostagem),

                    })
                    .then(response => {
                   
                        this.apartamento = response.data;
                    })
                    .catch(error => {
                        console.log(error)
                        console.log('erro ao adicionar apartamento');
                    });
            }
           
        },

        async upload(id) {
            this.file = this.$refs.file.files[0];

            let form = new FormData();
            form.append("resource", "apartamento");
            form.append("id", id);
            form.append("file", this.file);

            this.axios
                .post(this.baseUploadURI, form, {
                    headers: {
                        "Content-Type": "multipart/form-data",
                    },
                })
                .then((result) => {
                    console.log(result);
                });
        
          
        }
  
    }

}
</script>

<style>
</style>
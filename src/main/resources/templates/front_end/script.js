const agendamentoForm = document.getElementById('agendamentoForm');
const profissionalSelect = document.getElementById('profissional');
const agendamentosList = document.getElementById('agendamentosList');

async function carregarProfissionais() {
    const response = await fetch('/api/profissionais'); // Ajuste a URL conforme necessário
    const profissionais = await response.json();

    profissionais.forEach(profissional => {
        const option = document.createElement('option');
        option.value = profissional.id;
        option.textContent = profissional.nome;
        profissionalSelect.appendChild(option);
    });
}

async function carregarAgendamentos() {
    const response = await fetch('/api/agendamentos'); // Ajuste a URL conforme necessário
    const agendamentos = await response.json();

    agendamentosList.innerHTML = '';
    agendamentos.forEach(agendamento => {
        const li = document.createElement('li');
        li.textContent = `Profissional: ${agendamento.profissional.nome}, Data e Hora: ${new Date(agendamento.dataHora).toLocaleString()}`;
        agendamentosList.appendChild(li);
    });
}

agendamentoForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const profissionalId = profissionalSelect.value;
    const dataHora = document.getElementById('dataHora').value;

    const agendamento = { profissional: profissionalId, dataHora };

    await fetch('/api/agendamentos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(agendamento),
    });

    carregarAgendamentos();
});

// Carregar dados iniciais
carregarProfissionais();
carregarAgendamentos();

$(document).ready(function() {
    $('#programsTableContainer').jtable({
        title: 'Programs',
        defaultDateFormat: 'yyyy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        actions: {
            listAction: 'programs/getAllPrograms',
            createAction: 'programs/addProgram',
            updateAction: 'programs/updateProgram',
            deleteAction: 'programs/deleteProgram'
        },
        fields: {
            id: {
                title: 'ID',
                key: true,
                list: true,
                create: false,
                edit: false,
                visibility: 'hidden'
            },
            participant: {
                title: 'Participant'
            },
            description: {
                title: 'Description'
            },
            status: {
                title: 'Status',
                options: 'programs/statuses'
            },
            started: {
                title: 'Started on'
            }
        },
        recordAdded: function(event, data){
            $('#programsTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#programsTableContainer').jtable('load');
        }
    });
    $('#programsTableContainer').jtable('load');              
});
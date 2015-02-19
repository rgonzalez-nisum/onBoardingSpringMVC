$(document).ready(function() {
    $('#allProgramsTableContainer').jtable({
        title: 'Programs',
        defaultDateFormat: 'yy-mm-dd',
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
                list: false,
                key: true,
                create: false,
                edit: false,
                visibility: 'hidden'
            },
            participant: {
                title: 'Participant',
                options: 'programs/participants'
            },
            description: {
                title: 'Description',
                type: 'textarea'
            },
            status: {
                title: 'Status',
                options: 'programs/statuses'
            },
            started: {
                title: 'Started on',
                type: 'date'
            }
        },
        recordAdded: function(event, data){
            $('#allProgramsTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#allProgramsTableContainer').jtable('load');
        }
    });
    $('#allProgramsTableContainer').jtable('load');              
});
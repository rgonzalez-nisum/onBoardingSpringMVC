$(document).ready(function() {
    $('#participantsTableContainer').jtable({
        title: 'Participants',
        defaultDateFormat: 'yyyy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        actions: {
            listAction: 'participants/getAllParticipants',
            createAction: 'participants/addParticipant',
            updateAction: 'participants/updateParticipant',
            deleteAction: 'participants/deleteParticipant'
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
            name: {
                title: 'Name'
            },
            lastname: {
                title: 'Last name'
            },
            position: {
                title: 'Position',
                options: 'participants/positions'
            },
            email: {
                title: 'E-mail'
            }
        },
        recordAdded: function(event, data){
            $('#participantsTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#participantsTableContainer').jtable('load');
        }
    });
    $('#participantsTableContainer').jtable('load');              
});
$(document).ready(function() {
    $('#participantTableContainer').jtable({
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
                //width: '30%'
            },
            lastname: {
                title: 'Last name'
                //width: '15%'
            },
            position: {
                title: 'Position',
                options: 'participants/positions'
            },
            email: {
                title: 'E-mail'
                //width: '25%'
            }
        },
        recordAdded: function(event, data){
            $('#participantTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#participantTableContainer').jtable('load');
        }
    });
    $('#participantTableContainer').jtable('load');              
});
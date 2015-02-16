/* 
 * Javascript to manage the JTable
 */
$(document).ready(function() {
    //setup the jtable that will display the results
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
        //Register to selectionChanged event to hanlde events                                     
        recordAdded: function(event, data){
            //after record insertion, reload the records
            $('#participantTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            //after record updation, reload the records
            $('#participantTableContainer').jtable('load');
        }
    });
    $('#participantTableContainer').jtable('load');              
                
});
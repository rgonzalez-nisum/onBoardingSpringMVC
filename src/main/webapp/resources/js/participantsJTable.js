/* 
 * Javascript to manage the JTable
 */
$(document).ready(function() {
	if (typeof jQuery == 'undefined') {  
	    console.log("jQuery NOT LOADED")
	} else {
		console.log("jQuery LOADED")
	}
	
	if (typeof jtable == 'undefined') {  
	    console.log("jtable NOT LOADED")
	} else {
		console.log("jtable LOADED")
	}
	
    //setup the jtable that will display the results
    $('#participantTableContainer').jtable({
        title: 'Participants',
        selecting: true, //Enable selecting 
        paging: false, //Enable paging
        sorting: true, //Enable sorting
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
                edit: false
            },
            name: {
                title: 'Name',
                //width: '30%'
            },
            lastname: {
                title: 'Last name',
                //width: '15%'
            },
            position: {
                title: 'Position',
                options: 'participants/positions'
            },
            email: {
                title: 'E-mail',
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
//    $('#participantTableContainer').jtable('load');              
                
});
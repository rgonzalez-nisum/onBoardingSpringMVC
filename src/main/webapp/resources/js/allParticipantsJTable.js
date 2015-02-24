$(document).ready(function() {
    $('#allParticipantsTableContainer').jtable({
        title: 'Participants',
        defaultDateFormat: 'yyyy-mm-dd',
        selecting: true,
        sorting: true,
        multiSorting: true,
        openChildAsAccordion: true,
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
                options: 'positions/getAllPositionsAsOptions'
            },
            email: {
                title: 'E-mail'
            },
            programs: {
            	title: 'Programs',
            	width: '2%',
            	sorting: false,
            	edit: false,
            	create: false,
            	display: function (participant) {
                    var $img = $('<div class="jtable-programs-icon" title="View programs"/>');
                    
                    console.log(participant.record.programs);
                    console.log(participant.record.programs.lenght);
                    
                    $img.click(function () {
                        $('#allParticipantsTableContainer').jtable('openChildTable',
                                $img.closest('tr'),
                                {
                                    title: participant.record.name + ' - Programs',
                                    actions: {
                                        listAction: function (postData, jtParams) {
                                            return {
                                                "Result": "OK",
                                                "Records": participant.record.programs
                                            };
                                        }
                                    },
                                    fields: {
                                        participantId: {
                                            type: 'hidden',
                                            defaultValue: participant.record.id
                                        },
                                        id: {
                                            key: true,
                                            create: false,
                                            edit: false,
                                            list: false
                                        },
                                        description: {
                                            title: 'Description',
                                            type: 'textarea'
                                        },
                                        status: {
                                            title: 'Status',
                                            options: 'statuses/getAllProgramStatusesAsOptions'
                                        },
                                        started: {
                                            title: 'Started on',
                                            type: 'date',
                                            displayFormat: 'yy-mm-dd'
                                        }, 
                                        program: {
                                        	width: '2%',
                                        	display: function (program) {
                                                var $img = $('<div class="jtable-program-goto-icon" title="View program"/>');
                                                
                                                $img.click(function () {
                                                	$('<form action="programs/getProgramById" method="POST">'
                                                			+ '<input type="hidden" name="id" value="'+program.record.id+'">'
                                            		+ '</form>').submit();
                                                });
                                                return $img;
                                        	}
                                        }
                                    }
                                }, function (data) {
                                    data.childTable.jtable('load');
                                });
                    });
                    return $img;
            	}
            }
        },
        recordAdded: function(event, data){
            $('#allParticipantsTableContainer').jtable('load');
        },
        recordUpdated: function(event, data){
            $('#allParticipantsTableContainer').jtable('load');
        }
    });
    $('#allParticipantsTableContainer').jtable('load');              
});
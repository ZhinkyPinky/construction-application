import dayGridPlugin from '@fullcalendar/daygrid'; // a plugin!
import listPlugin from '@fullcalendar/list';
import FullCalendar from '@fullcalendar/react'; // must go before plugins
import resourceTimelinePlugin from '@fullcalendar/resource-timeline';
import timeGridPlugin from '@fullcalendar/timegrid';
import React, { useEffect, useState } from "react";
import ApiConnector from "../services/ApiConnector";

export default function Calendar() {
  const [loading, setLoading] = useState(true);
  const [calendarInfo, setCalendarInfo] = useState(null);

  useEffect(() => {
    // Gets all the warrenties on page load and runs only once
    const fetchData = async () => {
      setLoading(true);
      // Tries to get data from api
      try {
        const response = await ApiConnector.getCalendar();
        setCalendarInfo(response.data);
        console.log(JSON.stringify(response.data, null, 2))
        // Logs error if api cal not successful
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  return (
    <div className="p-7 text 2x1 font-semibold flex-1 h-screen">
      {!loading && (
        <div className="h-full">
        <FullCalendar
            plugins={[ dayGridPlugin, listPlugin, timeGridPlugin, resourceTimelinePlugin  ]}
            initialView="timeline"
            duration={{days: 1}}
            events={calendarInfo}
            height="100%"
            locale="sv"
            firstDay={1}
            headerToolbar={{
              left: "prev",
              center: "title",
              right: "next"
            }}
            views={{
              timeline: {
                type: 'timeline',
                duration: { months: 6 },
                buttonText: 'År',
                slotDuration: { months: 1 }
              }
            }}
            schedulerLicenseKey="GPL-My-Project-Is-Open-Source"
          />
          </div>
      )}
    </div>
  );
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Domain.Entities;

namespace WebUI.Models
{
    public class FilmListViewModel
    {
        public IEnumerable<Film> Films { get; set; }
        public PagingInfo PagingInfo { get; set; }
    }
}
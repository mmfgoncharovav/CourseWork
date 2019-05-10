using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Domain.Entities;

namespace Domain.Abstract
{
    public interface IFilmRepository
    {
        IEnumerable<Film> Films { get; }
        void SaveFilm(Film film);
        Film DeleteFilm(int filmId);
    }
}

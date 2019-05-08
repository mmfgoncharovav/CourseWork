using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Domain.Abstract;
using Domain.Entities;

namespace Domain.Concrete
{
    public class EFFilmRepository : IFilmRepository
    {
        EFDbContext context = new EFDbContext();

        public IEnumerable<Film> Films
        {
            get { return context.Films; }
        }
        public void SaveFilm(Film film)
        {
            if (film.FilmId == 0)
                context.Films.Add(film);
            else
            {
                Film dbEntry = context.Films.Find(film.FilmId);
                if (dbEntry != null)
                {
                    dbEntry.Name = film.Name;
                    dbEntry.Description = film.Description;
                    dbEntry.Price = film.Price;
                    dbEntry.Genre = film.Genre;
                }
            }
            context.SaveChanges();
        }
    }
}

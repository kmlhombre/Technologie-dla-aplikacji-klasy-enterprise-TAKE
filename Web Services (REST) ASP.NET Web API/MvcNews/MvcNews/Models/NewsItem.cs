using System.ComponentModel.DataAnnotations;

namespace MvcNews.Models
{
    public class NewsItem
    {
        public int Id { get; set; }
        [DataType(DataType.Date)]
        public DateTime TimeStamp { get; set; }
        [Required(ErrorMessage = "Required"),
         StringLength(140, MinimumLength = 5, ErrorMessage = "Minimum 5 characters, maximum 140 characters.")]
        public string Text { get; set; } = string.Empty;

        [Timestamp]
        public byte[]? RowVersion { get; set; }
    }
}